@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository servicePartRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    public ServicePartServiceImpl(ServicePartRepository servicePartRepository,
                                  ServiceEntryRepository serviceEntryRepository) {
        this.servicePartRepository = servicePartRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServicePart createServicePart(ServicePart servicePart) {

        Long serviceEntryId = servicePart.getServiceEntry().getId();

        ServiceEntry serviceEntry = serviceEntryRepository.findById(serviceEntryId)
                .orElseThrow(() ->
                        new RuntimeException("ServiceEntry not found with id: " + serviceEntryId)
                );

        // ✅ attach managed entity
        servicePart.setServiceEntry(serviceEntry);

        return servicePartRepository.save(servicePart);
    }
}
