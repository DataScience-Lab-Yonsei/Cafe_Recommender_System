# Crawling, Preprocessing
카카오맵, 네이버지도로부터의 크롤링과 그에 따른 데이터의 전처리 과정  

## Install
- pickle
- glob
- selenium
- Chromedriver : https://chromedriver.chromium.org/downloads 에서 다운로드  

  - chrome://version/ 에서 버전 확인 후 다운로드



## 파일 설명
**1. ~_crawling.ipynb**
  - **[중요]** jupyter notebook을 기준으로 작성됨
  - kakao_crawl_preprocess/kakaomap_crawling.ipynb, naver_crawl_preprocess/navermap_crawling.ipynb
  - 파일에서 요구하는 대로 실행하면 저장까지 완료됨

**2. ~_preprocess.ipynb**
- kakao_crawl_preprocess/kakao_preprocess.ipynb  

  - 크롤링해온 데이터 모두 합치기
  - 크롤링해온 데이터에서 크롤링해온 카페 자체가 중복인 경우 제거
  - 크롤링해온 데이터에서로부터 인지한 소상공인 데이터 자체가 중복인 경우 제거
  - user별 rating의 개수별로 나누어 csv 생성

- naver_crawl_preprocess/naver_preprocess.ipynb
  - 크롤링해온 데이터 모두 합치기
  - 크롤링해온 데이터에서 cafe가 아닌 행들을 모두 제거하는 과정
  - 크롤링해온 데이터에서 중복값(카페)들을 제거하는 과정
- public_preprocess/public_preprocess.ipynb
  - 주로 도로명주소 확인을 통한 중복값 제거 과정


## Reference    
- https://m.blog.naver.com/tamiblue/221723206818

