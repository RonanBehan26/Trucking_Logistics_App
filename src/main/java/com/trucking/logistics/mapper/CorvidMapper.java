package com.trucking.logistics.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.trucking.logistics.model.ErrorModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.trucking.logistics.util.ConstantUtil.FAILED;

@Component
public class CorvidMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(CorvidMapper.class);

    public String convertObjectToJson(Object obj) {
        ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException ex) {
            LOGGER.error(ex.toString());
        }
        return json == null || json.isEmpty() ? "" : json;
    }

    public String getError(Exception ex) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setErrorMessage(FAILED);
        LOGGER.error(ex.getMessage());
        return this.convertObjectToJson(errorModel);
    }

    public String getCustomError(String error) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setErrorMessage(error);
        LOGGER.error(error);
        return this.convertObjectToJson(errorModel);
    }

}
