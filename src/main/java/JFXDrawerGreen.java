import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class JFXDrawerGreen implements IDrawer{

    protected GraphicsContext g;

    public JFXDrawerGreen(GraphicsContext argG) {
        g = argG;
    }

    public JFXDrawerGreen() {
        g = null;
    }

    public void setG(GraphicsContext argG) {
        g = argG;
    }

    public void DrawSPoint(ICurve curve) {
        IPoint SPoint;
        SPoint = curve.GetPoint(0);
        g.setFill(Color.GREEN);
        g.fillOval(SPoint.GetX() - 5, SPoint.GetY() - 5, 10, 10);
    }

    public void DrawFPoint(ICurve curve) {
        IPoint FPoint, PFPoint;
        FPoint = curve.GetPoint(1);
        PFPoint = curve.GetPoint(0.95);
        g.setStroke(Color.GREEN);
        double ArrowLength1, ArrowLength2;
        ArrowLength1 = ArrowLength2 = 8;
        double dx = FPoint.GetX() - PFPoint.GetX();
        double dy = FPoint.GetY() - PFPoint.GetY();
        double LineLenght =  Math.sqrt(dx * dx + dy * dy);
        IPoint TempPoint, ArrowPoint1,ArrowPoint2;
        TempPoint = new Point();
        TempPoint.SetX(FPoint.GetX() - dx * (ArrowLength1/LineLenght));
        TempPoint.SetY(FPoint.GetY() - dy*(ArrowLength1/LineLenght));
        ArrowPoint1 = new Point();
        ArrowPoint1.SetX(TempPoint.GetX() + dy * (ArrowLength2/LineLenght));
        ArrowPoint1.SetY(TempPoint.GetY() - dx*(ArrowLength2/LineLenght));
        ArrowPoint2 = new Point();
        ArrowPoint2.SetX(TempPoint.GetX() - dy * (ArrowLength2/LineLenght));
        ArrowPoint2.SetY(TempPoint.GetY() + dx*(ArrowLength2/LineLenght));
        g.strokeLine(ArrowPoint1.GetX(), ArrowPoint1.GetY(), FPoint.GetX(), FPoint.GetY());
        g.strokeLine(ArrowPoint2.GetX(), ArrowPoint2.GetY(), FPoint.GetX(), FPoint.GetY());

    }

    public void DrawCurveBody(ICurve curve) {
        IPoint SPoint, TPoint1,TPoint2;
        SPoint = curve.GetPoint(0);
        g.setStroke(Color.GREEN);
        double step = 0.025;
        TPoint2 = SPoint;
        for (double i = step; i <= 1; i+=step) {
            TPoint1 = TPoint2;
            TPoint2 = curve.GetPoint(i);
            g.strokeLine(TPoint1.GetX(), TPoint1.GetY(), TPoint2.GetX(), TPoint2.GetY());
        }
        TPoint1 = curve.GetPoint(1 - step);
        TPoint2 = curve.GetPoint(1);
        g.strokeLine(TPoint1.GetX(), TPoint1.GetY(), TPoint2.GetX(), TPoint2.GetY());

    }

    public void Draw(ICurve curve) {
        DrawSPoint(curve);
        DrawFPoint(curve);
        DrawCurveBody(curve);
    }

    public void DrawOnlyBody(ICurve curve) {
        DrawCurveBody(curve);
    }

    public void DrawWithoutSPoint(ICurve curve) {
        DrawFPoint(curve);
        DrawCurveBody(curve);
    }

    public void DrawWithoutFPoint(ICurve curve) {
        DrawSPoint(curve);
        DrawCurveBody(curve);
    }

//    public void Draw(ACurve curve) {
//        IPoint SPoint, FPoint, TPoint1,TPoint2;
//        SPoint = curve.GetPoint(0);
//        FPoint = curve.GetPoint(1);
//        g.setStroke(Color.GREEN);
//        double step = 0.05;
//        TPoint2 = SPoint;
//        for (double i = step; i <= 1; i+=0.05) {
//            TPoint1 = TPoint2;
//            TPoint2 = curve.GetPoint(i);
//            g.strokeLine(TPoint1.GetX(), TPoint1.GetY(), TPoint2.GetX(), TPoint2.GetY());
//        }
//        g.setFill(Color.GREEN);
//        g.fillOval(SPoint.GetX() - 5, SPoint.GetY() - 5, 10, 10);
//
//
//
//    }


}
