

public class interface GarageService(){
    createGarage(Garage garage);
    updateGarage(Long id);
    getGarageByid(Long id);
    getAllGarages();
    deactivateGarage(Long id);
}