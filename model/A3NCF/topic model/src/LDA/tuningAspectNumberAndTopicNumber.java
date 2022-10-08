package LDA;

import java.io.File;
import java.io.IOException;

import LDA.atmGibbsSampling.modelparameters;

public class tuningAspectNumberAndTopicNumber {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int[] topicNums = {10}; // 수정 !!
		String[] datasets = {"A3NCF"}; // 수정 !!

		for (int t = 0; t < topicNums.length; t++) {
			int k = topicNums[t];
			for (int d = 0; d < datasets.length; d++) {
				String dataset = datasets[d];
				String originalDocsPath = "data/" + dataset + "_topicmodel_input_df_5.csv"; // 수정 !!
				String resultPath = "topicmodelresults/" + dataset + "/";	// 수정 !!
				// String parameterFile= ParameterConfig.LDAPARAMETERFILE;
				File create = new File(resultPath);
				if(!create.exists()){
					create.mkdirs();
				}

				modelparameters ldaparameters = new modelparameters();
				// getParametersFromFile(ldaparameters, parameterFile);
				Documents docSet = new Documents();
				docSet.readDocs(originalDocsPath);
				docSet.outPutIndex(resultPath);
				System.out.println("wordMap size " + docSet.tword2id.size());
				FileUtil.mkdir(new File(resultPath));
				userItemTopicModel model = new userItemTopicModel(ldaparameters);
				model.setTopicNum(k);
				model.setDataset(dataset);
				model.setResPath(resultPath);
				System.err.println("Dataset: " + dataset + "; TopicNum: " + model.getTopicNum());
				System.out.println("Saving path: " + model.getResPath());
				System.out.println("1 Initialize the model ...");
				model.initializeModel(docSet);
				System.out.println("2 Learning and Saving the model ...");
				model.inferenceModel(docSet);
				System.out.println("3 Output the final model ...");
				model.saveIteratedModel(ldaparameters.iteration, docSet);
				System.out.println("Done!");
			}
		}
	}
}
