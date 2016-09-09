package goep.hm.spc.service;

import goep.hm.spc.dao.ISPCDao;
import goep.hm.spc.model.SpcInput;
import goep.hm.spc.model.SpcResult;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Service implementaion of Sorting and saving of SPC Results
 * 
 *
 */
@Service("spcService")
public class SPCServiceImpl implements ISPCService {

	private Logger LOG = Logger.getLogger(SPCServiceImpl.class.getName());
	private static final long serialVersionUID = 1L;
	@Autowired
	private ISPCDao spcDao;

	@Transactional
	@Override
	public SpcResult sort(SpcInput input) {
		SpcResult resultToBeStored = new SpcResult();
		String inputString = input.getNumbers();
		// Split by new line
		String[] numbers = inputString.split("\n");
		LOG.info("splited " + numbers);

		// Calling the Sorting and counting time
		long startTime = System.currentTimeMillis();
		int[] result = bubbleSort(stringToIntgerArray(numbers), resultToBeStored);
		long endTime = System.currentTimeMillis();

		// Final Result
		String finalResult = printNumbers(result);
		LOG.info("finalResult " + finalResult);

		long timeTaken = endTime - startTime;

		resultToBeStored.setResult(finalResult);
		resultToBeStored.setTimeTaken(String.valueOf(timeTaken));

		// Saving the result
		saveResult(resultToBeStored);
		return resultToBeStored;
	}

	@Transactional
	@Override
	public void saveResult(SpcResult spcResult) {
		spcDao.save(spcResult);
	}

	@Transactional(readOnly = true)
	@Override
	public List<SpcResult> listResult() {
		return spcDao.findAll();
	}

	public static int[] bubbleSort(int array[], SpcResult resultToBeStored) {
		int positionChanges = 0;
		int n = array.length;
		int k;
		for (int m = n; m >= 0; m--) {
			for (int i = 0; i < n - 1; i++) {
				k = i + 1;
				if (array[i] > array[k]) {
					swapNumbers(i, k, array);
					positionChanges++;
				}
			}
			printNumbers(array);
		}
		resultToBeStored.setPositionChanges(String.valueOf(positionChanges));
		return array;
	}

	private static void swapNumbers(int i, int j, int[] array) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static String printNumbers(int[] input) {
		String s = "";
		for (int i = 0; i < input.length; i++) {
			s = s + input[i] + ", ";
		}

		return s;
	}

	private int[] stringToIntgerArray(String[] numbers) {
		int[] intgerArray = new int[numbers.length];
		try {
			LOG.info("stringToIntgerArray Start " + numbers);
			for (int i = 0; i < numbers.length; i++) {
				intgerArray[i] = Integer.valueOf(numbers[i].trim());
			}
			LOG.info("stringToIntgerArray End " + intgerArray);

		} catch (Exception e) {
			LOG.info("stringToIntgerArray Exception " + e.getMessage());
		}
		return intgerArray;
	}
}
