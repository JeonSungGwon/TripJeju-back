let currentPage = 0; // 현재 페이지 번호, 0에서 시작
const pageSize = 10; // 페이지당 표시할 아이템 수
let totalPages = 534; // 총 페이지 수
let map; // 전역 변수로 지도 객체를 저장
let markers = []; // 마커를 저장할 배열

document.addEventListener('DOMContentLoaded', function() {
    initializeMap(); // 지도 초기화 함수
    loadSpots(currentPage);
});

function initializeMap() {
    var mapOptions = {
        center: new naver.maps.LatLng(33.3617, 126.5292),
        zoom: 10
    };
    map = new naver.maps.Map('mapContainer', mapOptions);
}
// 서버로부터 데이터를 가져와서 화면에 표시하는 함수
function loadSpots(page) {
    fetch(`/spots?page=${page}&size=${pageSize}`)
        .then(response => response.json())
        .then(data => {
            const listContainer = document.getElementById('listContainer');
            listContainer.innerHTML = ''; // 리스트 컨테이너 비우기
            clearMarkers(); // 기존 마커 제거
            if (data.length > 0 && data[0].count !== undefined) {
                const totalCount = parseInt(data[0].count, 10); // 정수형으로 변환
                totalPages = Math.ceil(totalCount / pageSize); // 올림 함수를 사용하여 페이지 수 계산
            }
            data.forEach(spot => {
                const listItem = document.createElement('div');
                listItem.innerHTML = `<h3>${spot.title}</h3><img src="${spot.imgPath}" alt="${spot.title}" style="width:100%;"><p>${spot.introduction}</p>`;
                listContainer.appendChild(listItem);

                // 새로운 마커 생성 및 배열에 추가
                const marker = new naver.maps.Marker({
                    position: new naver.maps.LatLng(spot.latitude, spot.longitude),
                    map: map
                });
                markers.push(marker);
                var contentString = [
                    `<div class="iw_inner">`,
                    `   <img src="${spot.thumbnailPath}" width=140 />`,   
                    `   <h3>${spot.title}</h3>`,
                    `   <p>${spot.roadAddress}</p>`,
                    `   <a href="http://www.seoul.go.kr" target="_blank">www.seoul.go.kr/</a>`,
                    '</div>'
                ].join('');
                const infowindow = new naver.maps.InfoWindow({
                    content: contentString,
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
            updatePageNumbers(page);
        })
        .catch(error => console.error('Error loading the spots:', error));
}

function updatePageNumbers(currentPage) {
    const pageNumbers = document.getElementById('pageNumbers');
    pageNumbers.innerHTML = `Page ${currentPage + 1} of ${totalPages}`; // 현재 페이지 번호만 표시
}

function changePage(page) {
    if (page < 0 || page >= totalPages) return;
    currentPage = page;
    loadSpots(currentPage);
}

function clearMarkers() {
    markers.forEach(marker => marker.setMap(null));
    markers = [];
}

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