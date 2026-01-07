package com.dth.service;

import com.dth.model.NumpyData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NumpyDataService {

    private final List<NumpyData> numpyDataList = new ArrayList<>();

    public NumpyDataService() {
        // Initialize with sample numpy data
        NumpyData sample = new NumpyData();
        sample.setId("numpy_001");
        sample.setTitle("Sample Numpy Array");
        sample.setValues(new double[]{1.0, 2.0, 3.0, 4.0, 5.0});
        sample.setDataType("float64");
        sample.setShape(5);
        numpyDataList.add(sample);
    }

    public List<NumpyData> getAllNumpyData() {
        return new ArrayList<>(numpyDataList);
    }

    public NumpyData getNumpyDataById(String id) {
        return numpyDataList.stream()
                .filter(data -> data.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public NumpyData createNumpyData(NumpyData data) {
        numpyDataList.add(data);
        return data;
    }
}
