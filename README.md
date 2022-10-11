# 리뷰, 별점, 키워드를 활용한 카페 추천 시스템
카카오맵(리뷰, 별점), 네이버지도(키워드)를 활용하여 서울시 내 카페 추천 시스템 구현
  
  
## DSL 22-2 modeling project C조 
**팀명** : 조 이름 추천해조😏  
**팀원** : 김경한 김지희 박지은 이승주 이재우  
**발표 영상** : [프로젝트 발표 영상 링크 (1:06:16~1:24:24)](https://youtu.be/QVdFWApKydw) 
  
## 👁Overview
**1. 프로젝트 개요**
- **목적** : 오직 위치 기반의 카페 추천이 아닌, **이용자의 선호**에 맞는 카페를 추천하는 시스템 구현
- **방법** : 서울시 내 카페의 리뷰, 별점, 키워드를 활용.

**2. 데이터 수집**
- 소상공인시장진흥공단_상가(상권)정보

  - 상호명, 업종명, 주소 등을 포함하여 상가업소에 대한 다양한 정보가 포함
  - 시도명 == '서울특별시', 상권업종중분류코드 == '커피점/카페'인 행만 추출
  
- [카카오맵](https://map.kakao.com) 크롤링 

  - 소상공인 데이터의 '지점명+상호명'을 검색하여, 각 카페의 **'리뷰'**, **'별점'** 등을 수집
  
- [네이버지도](https://map.naver.com) 크롤링

  - 소상공인 데이터의 '지점명+상호명'을 검색하여, 각 카페의 **'키워드'** 의 투표수를 수집
  - 키워드 15개 : '커피가 맛있어요', '친절해요', '음료가 맛있어요', '디저트가 맛있어요', '매장이 청결해요', '대화하기 좋아요', '집중하기 좋아요', '인테리어가 멋져요', '특별한 메뉴가 있어요',' 가성비가 좋아요', '좌석이 편해요', '화장실이 깨끗해요', '뷰가 좋아요'

**3. 추천시스템 구현**
- 서울 전체, 구별로 나누어 카페 추천
- Content-Based Filtering

  - Cosine-Similarity : 특정 카페와 가장 유사도가 높은 카페 도출
  - Machine learning : 사용자별로 그동안의 별점을 바탕으로, 카페의 특징에 따라 별점 예측
- Collaborative Filtering

  - Neighbor-Based : 사용자와 취향이 비슷한 다른 사용자가 좋아하는 카페를 추천
  - Matrix-Factorization : user-cafe matrix를 user-feature, cafe-feature matrix로 분해하여 latent feature 도출
  
- A3NCF : input(user,cafe의 review,embedding 각각), feature fusion, attention interaction, rating prediction을 통해 별점 예측

## 📜Results
- '**안다르커피**'에 별점을 매긴 사용자에게 카페 추천 (or '안다르커피'와 유사한 카페 추천)
- 추천시스템의 결과를 종합한 결과, 서대문구 내에서는 '가빈커피', 'AtoZ', '벤치커피스튜디오'가 가장 많이 추천됨.
- '안다르커피'의 특징이라고 여기는, 공부하는 분위기와는 먼 카페들도 추출됨

  - '안다르커피'는 키워드 중 '커피가 맛있어요'의 투표수가 가장 많았음이 반영된 결과

## 📁폴더 구조 설명
폴더의 자세한 내용은 **폴더 내부의 README**에 있습니다.  

**1. crawl_preprocess**
- 카카오맵, 네이버지도에 대한 크롤링
- raw_data에 대한 전처리 과정 
 
**2. data**
- crawl_preprocess가 모두 완료된, model에서 사용될 data  

**3. model**
- 추천시스템 구현을 위한 model  

**4. raw_data**
- 전처리하기 이전 데이터

**5. 모델링 C조.pdf**
- 프로젝트 발표 자료

## Reference
- [소상공인시장진흥공단_상가(상권)정보](https://www.data.go.kr/data/15083033/fileData.do)  
- <책> Python을 이용한 개인화 추천시스템 – 임일  
- <유튜브 강의> [스탠포드 강의](https://www.youtube.com/watch?v=1JRrCEgiyHM)  
- <유튜브 강의> [Recommender Systems | Problem Formulation — [ Machine Learning | Andrew Ng ]](https://www.youtube.com/watch?v=giIXNoiqO_U&list=PL-6SiIrhTAi6x4Oq28s7yy94ubLzVXabj)
