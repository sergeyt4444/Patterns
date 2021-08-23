import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        JFXDrawerBlack jfxDrawer1 = new JFXDrawerBlack();
        JFXDrawerBlack jfxDrawer2 = new JFXDrawerBlack();
        IDrawer consoleDrawer = new ConsoleDrawer();

        IPoint a = new Point();
        a.SetX(100);
        a.SetY(100);
        IPoint b = new Point();
        b.SetX(300);
        b.SetY(140);
        IPoint c = new Point();
        c.SetX(150);
        c.SetY(130);
        IPoint d = new Point();
        d.SetX(250);
        d.SetY(170);
        Line visualLine = new Line(a,b);
        Bezier visualBezier = new Bezier(a,b,c,d);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(100,100,100,100));
        hBox.setSpacing(200);

        final Canvas canvasN = new Canvas(400,400);
        GraphicsContext gN = canvasN.getGraphicsContext2D();
        gN.setStroke(Color.BLACK);
        gN.setLineWidth(2);
        gN.strokeRect(0, 0, 400, 400);
        jfxDrawer1.setG(gN);
        visualLine.SetDrawer(jfxDrawer1);
        visualLine.Draw();
        visualLine.SetDrawer(consoleDrawer);
        visualLine.Draw();

        System.out.print("\n\n\n");


        final Canvas canvasS = new Canvas(400,400);
        GraphicsContext gS = canvasS.getGraphicsContext2D();
        gS.setStroke(Color.BLACK);
        gS.setLineWidth(2);
        gS.strokeRect(0, 0, 400, 400);
        jfxDrawer2.setG(gS);
        visualBezier.SetDrawer(jfxDrawer2);
        visualBezier.Draw();
        visualBezier.SetDrawer(consoleDrawer);
        visualBezier.Draw();

        Group root = new Group();
        hBox.getChildren().addAll(canvasN, canvasS);
        root.getChildren().add(hBox);

        //Creating a Scene
        Scene scene = new Scene(root, 1400, 600);

        //Setting title to the scene
        stage.setTitle("Sample application");

        //Adding the scene to the stage
        stage.setScene(scene);

        //Displaying the contents of a scene
        stage.show();
    }

}
