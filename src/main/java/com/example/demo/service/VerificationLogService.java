

public interface VerificationLogService(){
    createLog(VerificationLog log);
    getLogsFormEntry(Long entryId);
    getLogById(Long id);  
}