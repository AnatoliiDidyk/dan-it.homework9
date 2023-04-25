public class FamilyService {

    private FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = getAllFamilies();
        for (int i = 0; i < families.size(); i++) {
            System.out.println((i + 1) + ". " + families.get(i).toString());
        }
    }

    public List<Family> getFamiliesBiggerThan(int number) {
        return familyDao.getFamiliesBiggerThan(number);
    }

    public List<Family> getFamiliesLessThan(int number) {
        return familyDao.getFamiliesLessThan(number);
    }

    public int countFamiliesWithMemberNumber(int number) {
        return familyDao.countFamiliesWithMemberNumber(number);
    }

    public void createNewFamily(Human mother, Human father) {
        familyDao.createNewFamily(new Family(mother, father));
    }

    public void deleteFamilyByIndex(int index) {
        familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String masculineName, String feminineName) {
        Human child = family.bornChild(masculineName, feminineName);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThan(int age) {
        familyDao.deleteAllChildrenOlderThan(age);
    }

    public int count() {
        return familyDao.count();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public List<Pet> getPets(int index) {
        return familyDao.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyDao.addPet(index, pet);
    }
}