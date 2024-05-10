let currentPage = 0;
const pageSize = 10;
let map; // 전역 변수로 지도 객체를 저장
let markers = []; // 마커를 저장할 배열

document.addEventListener('DOMContentLoaded', function() {
    initializeMap(); // 지도 초기화 함수
    loadSpots(currentPage);
});

// 지도 초기화 함수
function initializeMap() {
    var mapOptions = {
        center: new naver.maps.LatLng(33.3617, 126.5292),
        zoom: 10
    };
    map = new naver.maps.Map('mapContainer', mapOptions);
}

// 마커를 지우는 함수
function clearMarkers() {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
    }
    markers = []; // 마커 배열을 비움
}

// 서버로부터 데이터를 가져와서 화면에 표시하는 함수
function loadSpots(page) {
    fetch(`/spots?page=${page}&size=${pageSize}`)
        .then(response => response.json())
        .then(spots => {
            const listContainer = document.getElementById('listContainer');
            listContainer.innerHTML = ''; // 리스트 컨테이너 비우기
            clearMarkers(); // 기존 마커 제거
            spots.forEach(spot => {
                const listItem = document.createElement('div');
                listItem.innerHTML = `<h3>${spot.title}</h3><img src="${spot.thumbnailPath}" alt="${spot.title}" style="width:100%;"><p>${spot.introduction}</p>`;
                listContainer.appendChild(listItem);

                // 새로운 마커 생성 및 배열에 추가
                const marker = new naver.maps.Marker({
                    position: new naver.maps.LatLng(spot.latitude, spot.longitude),
                    map: map
                });
                markers.push(marker);

                const infowindow = new naver.maps.InfoWindow({
                    content: spot.title,
                    maxWidth: 140,
                    backgroundColor: "#eee",
                    borderColor: "#2db400",
                    borderWidth: 5,
                    anchorSize: new naver.maps.Size(30, 30),
                    anchorSkew: true,
                    anchorColor: "#eee",
                    pixelOffset: new naver.maps.Point(20, -20)
                });
                naver.maps.Event.addListener(marker, "click", function(e) {
                    if (infowindow.getMap()) {
                        infowindow.close();
                    } else {
                        infowindow.open(map, marker);
                    }
                });
            });
            updatePageNumber(page);
        })
        .catch(error => console.error('Error loading the spots:', error));
}

// 페이지네이션 버튼 핸들러
function previousPage() {
    if (currentPage > 0) {
        currentPage -= 1;
        loadSpots(currentPage);
    }
}

function nextPage() {
    currentPage += 1;
    loadSpots(currentPage);
}

function updatePageNumber(page) {
    document.getElementById('pageNumber').textContent = page + 1;
}
