import java.io.File;
public class SystemFichier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fo = new File("tes.txt");
		System.out.println("Chemin absolu du fichier: "+ fo.getAbsolutePath());
		System.out.println("Nom du fichier : "+ fo.getName());
		System.out.println("Est ce qu'il existe ? "+ fo.exists());
		System.out.println("Est ce un repectoire ? "+ fo.isDirectory());
		System.out.println("Est ce un fichier ? " + fo.isFile());
		System.out.println("Affichage des lecteurs à la racine du PC :");
		for(File file: fo.listRoots()){
			System.out.println(file.getAbsolutePath());
		}

	} 
	

}
