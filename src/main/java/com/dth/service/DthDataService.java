package com.dth.service;

import com.dth.model.DthData;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class DthDataService {
    
    private final Map<Long, DthData> dataStore = new HashMap<>();
    private long idCounter = 1L;

    public DthDataService() {
        // Initialize with sample data
        DthData sample = new DthData();
        sample.setId(idCounter++);
        sample.setName("Sample DTH Data");
        sample.setDescription("Initial sample data");
        sample.setData("Sample content");
        sample.setCreatedAt(LocalDateTime.now());
        sample.setUpdatedAt(LocalDateTime.now());
        dataStore.put(sample.getId(), sample);
    }

    public Map<Long, DthData> getAllDthData() {
        return new HashMap<>(dataStore);
    }

    public DthData getDthDataById(Long id) {
        return dataStore.get(id);
    }

    public DthData createDthData(DthData data) {
        data.setId(idCounter++);
        data.setCreatedAt(LocalDateTime.now());
        data.setUpdatedAt(LocalDateTime.now());
        dataStore.put(data.getId(), data);
        return data;
    }

    public DthData updateDthData(Long id, DthData data) {
        if (dataStore.containsKey(id)) {
            data.setId(id);
            data.setUpdatedAt(LocalDateTime.now());
            dataStore.put(id, data);
            return data;
        }
        return null;
    }

    public boolean deleteDthData(Long id) {
        return dataStore.remove(id) != null;
    }
}
