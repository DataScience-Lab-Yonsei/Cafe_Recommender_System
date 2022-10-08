# A3NCF

- 파일 설명
    - data preprocessing  
    
        - rawdata_for_A3NCF
        
            - review_n.csv
            - review_n_user.csv
            - review_n_item.csv
            
        - topicmodel_data_preprocess_n.ipynb: rawdata_for_A3NCF 내 데이터 전처리
        - topicmodel_input_split.ipynb: topicmodel_data_preprocess에서 전처리한 데이터 분할  
        
    - topic model
        - data: topic modeling의 input (data preprocessing의 output)
        - src: topic modeling을 실행하기 위한 java 파일  
        
            - src > LDA > [tuningAspectNumberAndTopicNumber.java](http://tuningAspectNumberAndTopicNumber.java): topic modeling 실행 코드
        - topicmodelresults: topic modeling의 output (python의 input)
    - python
        - data: Attention Neural Network의 input (topic model의 output, data preprocessing의 output)
        - pretrain: 학습된 모델 및 가중치
        - results: 모델의 성능 평가 결과 (mae, rmse)
        - Dataset_custom.py: Attention Neural Network의 input 전처리
        - ancf_custom.py: Attention Neural Network
        - evaluate.py: Attention Neural Network의 성능 평가
        - run_final.ipynb: Attention Neural Network 실행 코드  
        
- 실행 방법
    1. data preprocessing > topicmodel_data_preprocess_n.ipynb: 데이터 전처리
      - input
          - data preprocessing > rawdata_for_A3NCF > review_n.csv
      - output
          - data preprocessing > rawdata_for_A3NCF > review_n_item/user.csv: item 및 user의 index dataframe
          - topic model > data > A3NCF_topicmodel_input_df_n.csv: topic model의 input
    2. data preprocessing > topicmodel_input_split.ipynb: 데이터 분할 (train, test, validation)
      - input
          - topic model > data > A3NCF_topicmodel_input_df_n
      - output
          - topic model > data > A3NCF_train/test/valid_n.dat
    3. topic model > src > LDA > tuningAspectNumberAndTopicNumber.java: topic modeling 실행
        - input
            - topic model > data > A3NCF_train_n.dat
        - output
            - topic model > topicmodelresults > A3NCF_X_X
            - 폴더명 형식: A3NCF_[factor개수]_[dataset]
    4. python: python > run_final.ipynb: Attention Neural Network 실행
        - input
            - python > data > A3NCF_X_X > A3NCF.10.item/user.theta
                
                (= topic model > topicmodelresults > A3NCF_X_X > A3NCF.10.item/user.theta)
                
            - python > data > A3NCF_X_X > A3NCF.train/test.dat
        - output
            - python > pretrain > X_X.h5
- reference
    - [https://github.com/hustlingchen/A3NCF](https://github.com/hustlingchen/A3NCF)
