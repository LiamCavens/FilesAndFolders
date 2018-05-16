package folderAndFiles;

import folderAndFiles.db.DBFolder;
import folderAndFiles.db.DBHelper;
import folderAndFiles.db.DBOwner;
import folderAndFiles.models.File;
import folderAndFiles.models.Folder;
import folderAndFiles.models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Owner owner = new Owner("Liam", "Dragon");
        Folder folder1 = new Folder("Spoons", owner);
        Folder folder2 = new Folder("Shovels", owner);
        File file1 = new File("Big Spoon", ".pdf", 4, folder1);
        File file2 = new File("Wee Spoon", ".pdf", 3, folder1);
        File file3 = new File("Wooden Shovel", ",text", 6, folder2);
        File file4 = new File("Metal Shovel", ",text", 8, folder2);

        DBHelper.saveOrUpdate(owner);
        DBHelper.saveOrUpdate(folder1);
        DBHelper.saveOrUpdate(folder2);
        DBHelper.saveOrUpdate(file1);
        DBHelper.saveOrUpdate(file2);
        DBHelper.saveOrUpdate(file3);
        DBHelper.saveOrUpdate(file4);

        List<File> files = DBHelper.getAll(File.class);
        List<Folder> folders = DBHelper.getAll(Folder.class);

        Folder foundSpoonFolder = DBHelper.find(Folder.class, folder1.getId());
        Folder foundShovelFolder = DBHelper.find(Folder.class, folder2.getId());

        List<File> spoonFiles = DBFolder.getFilesInFolder(foundSpoonFolder);
        List<File> shovelFiles = DBFolder.getFilesInFolder(foundShovelFolder);

        Owner foundOwner = DBHelper.find(Owner.class, owner.getId());
        List<Folder> ownerFolders = DBOwner.getFoldersOwnerHas(foundOwner);
    }
}
