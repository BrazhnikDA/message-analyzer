package liga.medical.messageanalyzer.core.service;

import liga.medical.messageanalyzer.core.api.LogHelper;
import liga.medical.messageanalyzer.core.api.LogService;
import liga.medical.messageanalyzer.core.dto.LogRestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogServiceImpl implements LogService {

    private LogHelper logHelper;

    public LogServiceImpl(LogHelper logHelper) {
        this.logHelper = logHelper;
    }

    @Override
    public void logRest(String className, String methodName) {
        LogRestDto logRestDto = new LogRestDto();
        logRestDto.setId(logHelper.getId());
        logRestDto.setDate(logHelper.getCurrentDate());
        logRestDto.setTime(logHelper.getCurrentTime());
        logRestDto.setClassName(className);
        logRestDto.setMethodName(methodName);
        //logRestDto.setUserName(this.getUsername());
        log.info(logRestDto.toString());
    }
}
