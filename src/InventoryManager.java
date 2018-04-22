import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class InventoryManager {
    private final String COOKIE_FACTORY_DATA = "cookieFactory.info" ;
    HashMap<String,Integer> rawmat_inventory;
    HashMap<String,Integer> merchandise_inventory;
    HashMap<String,HashMap> recipes;


    public InventoryManager(){
        rawmat_inventory = new HashMap();
        merchandise_inventory = new HashMap();
        //System.out.println(System.getProperty("user.dir"));
        initializeInventory();
    }

    private void initializeInventory(){
        String data = readFile(COOKIE_FACTORY_DATA);
        String[] parts = data.split("#");
        System.out.println(parts[3]);

        //Initializing Raw Materials
        String[] raw_materials = parts[3].split("\n");
        int no_of_raw_materials = raw_materials.length;
        //System.out.println(no_of_raw_materials);
        for(int i = 1;i < no_of_raw_materials;i++){
            rawmat_inventory.put(raw_materials[i].split(" ")[0],Integer.parseInt(raw_materials[i].split(" ")[1]));
        }
        System.out.println(rawmat_inventory);

        //Initializing Merchadise
        String[] Merchadise = parts[4].split("\n");
        int no_of_merchandise = Merchadise.length;
        //System.out.println(no_of_merchandise);
        for(int i = 1;i < no_of_merchandise;i++){
            merchandise_inventory.put(Merchadise[i].split(" ")[0],Integer.parseInt(Merchadise[i].split(" ")[1]));
        }
        System.out.println(merchandise_inventory);

        //understand recipies
        HashMap<HashMap, Integer> ingredientsvtime = new HashMap();
        HashMap<String, Integer> ingredientquatity = new HashMap();
        String[] recepies = parts[2].split("\n");
        int no_of_recepies = Merchadise.length;
        System.out.println(recepies[1]);

        for(int i = 1;i < no_of_recepies;i++){
            String[] products = recepies[i].split("\\[[^\\[]*\\]");
            System.out.println(products[1]);
            //int no_of_ingredients = recepies[i].split(" ")[0];
            //recipes.put(recepies[i].split(" ")[0],Integer.parseInt(recepies[i].split(" ")[1]));
        }




    }


    private String readFile(String filename){
        String line = null;
        String filedata = "";
        try{
            FileReader fileReader =
                    new FileReader(System.getProperty("user.dir") + "/src/" + filename);
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                filedata = filedata + line +  '\n';

            }
            bufferedReader.close();
            return filedata;
        }catch (IOException ex){
            System.out.println(ex.toString());
            return  ex.toString();

        }
    }

}
