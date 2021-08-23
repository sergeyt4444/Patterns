
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;


public class UserInterfaceWithComposite extends Application {

    ACurve currentCurve;

    @Override
    public void start(Stage stage) throws Exception {
        JFXDrawerBlack jfxDrawer1 = new JFXDrawerBlack();
        JFXDrawerGreen jfxDrawer2 = new JFXDrawerGreen();
        SVGDrawerBlack svgDrawerBlack = new SVGDrawerBlack();
        SVGDrawerGreen svgDrawerGreen = new SVGDrawerGreen();
        IDrawer consoleDrawer = new ConsoleDrawer();

        IPoint a = new Point();
        a.SetX(100);
        a.SetY(100);
        IPoint b = new Point();
        b.SetX(160);
        b.SetY(112);
        IPoint c = new Point();
        c.SetX(115);
        c.SetY(109);
        IPoint d = new Point();
        d.SetX(145);
        d.SetY(121);
        IPoint e = new Point();
        e.SetX(10);
        e.SetY(10);
        Line visualLine = new Line(a,b);
        Bezier visualBezier = new Bezier(a,b,c,d);
        MoveTo moveTo = new MoveTo(visualLine, e);
        MoveTo moveTo1 = new MoveTo(moveTo, c);
        Fragment fragment = new Fragment(moveTo, 0, 0.5);
        Reverse reverse = new Reverse(fragment);
        Chain chain = new Chain(visualLine, visualBezier);
        Chain chain1 = new Chain(chain, visualLine);
        ArrayList<ICurve> curves = new ArrayList<ICurve>();
        curves.add(visualLine);
        curves.add(visualBezier);
        curves.add(visualLine);
        MultiChain multiChain = new MultiChain(curves);

        VBox BigBox = new VBox();
        BigBox.setPadding(new Insets(10,10,10,10));
        BigBox.setSpacing(20);
        BigBox.setAlignment(Pos.BASELINE_CENTER);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(100,100,100,100));
        hBox.setSpacing(200);

        VBox vBox1 = new VBox();
        vBox1.setPadding(new Insets(10,10,10,10));
        vBox1.setSpacing(20);
        vBox1.setAlignment(Pos.BASELINE_CENTER);

        VBox vBox2 = new VBox();
        vBox2.setPadding(new Insets(10,10,10,10));
        vBox2.setSpacing(20);
        vBox2.setAlignment(Pos.BASELINE_CENTER);

        final Canvas canvasN = new Canvas(400,400);
        GraphicsContext gN = canvasN.getGraphicsContext2D();
        gN.setStroke(Color.BLACK);
        gN.setLineWidth(2);
        gN.strokeRect(0, 0, 400, 400);
        jfxDrawer1.setG(gN);

        Button buttonSVG1 = new Button("Convert to SVG");
        buttonSVG1.setDisable(true);

        buttonSVG1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                currentCurve.SetDrawer(svgDrawerBlack);
                currentCurve.Draw();
            }
        });

        final Canvas canvasS = new Canvas(400,400);
        GraphicsContext gS = canvasS.getGraphicsContext2D();
        gS.setStroke(Color.BLACK);
        gS.setLineWidth(2);
        gS.strokeRect(0, 0, 400, 400);
        jfxDrawer2.setG(gS);

        Button buttonSVG2 = new Button("Convert to SVG");
        buttonSVG2.setDisable(true);
        buttonSVG2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                currentCurve.SetDrawer(svgDrawerGreen);
                currentCurve.Draw();
            }
        });

        Button buttonLine = new Button("Generate multichain");
        buttonLine.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                gS.clearRect(0, 0, 400, 400);
                gN.clearRect(0, 0, 400, 400);
                gS.setStroke(Color.BLACK);
                gN.strokeRect(0, 0, 400, 400);
                gS.strokeRect(0, 0, 400, 400);
                multiChain.SetDrawer(jfxDrawer1);
                multiChain.Draw();
                multiChain.SetDrawer(jfxDrawer2);
                multiChain.Draw();
                multiChain.SetDrawer(consoleDrawer);
                multiChain.Draw();
                buttonSVG1.setDisable(false);
                buttonSVG2.setDisable(false);
                currentCurve = multiChain;
            }
        });

        Button buttonChain = new Button("Generate chain");
        buttonChain.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                gS.clearRect(0, 0, 400, 400);
                gN.clearRect(0, 0, 400, 400);
                gS.setStroke(Color.BLACK);
                gN.strokeRect(0, 0, 400, 400);
                gS.strokeRect(0, 0, 400, 400);
                chain1.SetDrawer(jfxDrawer1);
                chain1.Draw();
                chain1.SetDrawer(jfxDrawer2);
                chain1.Draw();
                chain1.SetDrawer(consoleDrawer);
                chain1.Draw();
                buttonSVG1.setDisable(false);
                buttonSVG2.setDisable(false);
                currentCurve = chain1;
            }
        });


        Group root = new Group();
        vBox1.getChildren().addAll(canvasN, buttonSVG1);
        vBox2.getChildren().addAll(canvasS, buttonSVG2);
        hBox.getChildren().addAll(vBox1, vBox2);
        BigBox.getChildren().addAll(hBox, buttonLine, buttonChain);
        root.getChildren().add(BigBox);

        //Creating a Scene
        Scene scene = new Scene(root, 1250, 800);

        //Setting title to the scene
        stage.setTitle("Sample application");

        //Adding the scene to the stage
        stage.setScene(scene);

        //Displaying the contents of a scene
        stage.show();

    }

}
