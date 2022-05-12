
import editor.EditorWindow;

public class Main {
	public static void main(String[] args) {
		EditorWindow window = new EditorWindow();
		new Thread(window).run();
	}
}
