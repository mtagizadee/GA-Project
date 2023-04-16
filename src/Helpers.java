import java.util.Random;

public class Helpers {

    public static int rand(int min,int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public static String[] getDestinationsNames() {
        return new String[]{
                "Azerbaijan",
                "France",
                "United-States",
                "Germany",
                "Switzerland",
                "Japan",
                "China",
                "Russia",
                "Ukraine",
                "England"
        };
    }

    public static String[] getStudentsNames() {
        return new String[]{
                "Mahammad",
                "Khazar",
                "Babek",
                "Ibrahim",
                "Azim",
                "Kanan",
                "Hamid",
                "Farid",
                "Ravan",
                "Gadir",
                "Iskender",
                "Nazrin",
                "Shams",
                "Narmin",
                "Nigar",
                "Aytan",
                "Sabina",
                "Arif",
                "Murad",
                "Kamal",
                "Amina",
                "Lala",
                "Aydan",
                "Nijat",
                "Ilkin",
                "Orkhan",
                "Aydin",
                "Adil",
                "Omar",
                "Sanan",
                "Huseyn",
                "Ramiz",
                "Razi",
                "Natiq",
                "Javid",
                "Jamal",
                "Togrul",
                "Aziz",
                "Parviz",
                "Abbas"
        };
    }
}
