package com.example.handyman.service.pgImpl;

import com.example.handyman.dao.HandymanDAO;
import com.example.handyman.entity.HandymanEntity;
import com.example.handyman.service.HandymanService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Log4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PGHandymanService implements HandymanService {

    private HandymanDAO handymanDAO;

    @Override
    public HandymanEntity getHandymanById(Long id) {
        HandymanEntity handymanEntity = handymanDAO.getOne(id);
        log.info(handymanEntity);
        return handymanEntity;
    }

    @Override
    public List<HandymanEntity> getAllHandyman() {
        return handymanDAO.getAllByCreateDateBefore(new Date());
    }
}
