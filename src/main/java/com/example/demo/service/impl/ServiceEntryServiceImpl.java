@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServiceEntry save(ServiceEntry entry) {

        ServiceEntry last = serviceEntryRepository
                .findTopByVehicleOrderByOdometerReadingDesc(entry.getVehicle());

        if (last != null) {
            if (entry.getOdometerReading() < last.getOdometerReading()) {
                throw new IllegalArgumentException("Odometer reading cannot be less than previous");
            }
        }

        return serviceEntryRepository.save(entry);
    }

    @Override
    public List<ServiceEntry> getByVehicleId(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }

    @Override
    public List<ServiceEntry> getByGarageAndMinOdometer(Long garageId, int minOdometer) {
        return serviceEntryRepository.findByGarageAndMinOdometer(garageId, minOdometer);
    }

    @Override
    public List<ServiceEntry> getByVehicleAndDateRange(
            Long vehicleId,
            LocalDate startDate,
            LocalDate endDate
    ) {
        return serviceEntryRepository.findByVehicleAndDateRange(
                vehicleId, startDate, endDate
        );
    }
}
