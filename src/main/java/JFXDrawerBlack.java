import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class JFXDrawerBlack implements IDrawer{

    protected GraphicsContext g;

    public JFXDrawerBlack(GraphicsContext argG) {
        g = argG;
    }

    public JFXDrawerBlack() {
        g = null;
    }

    public void setG(GraphicsContext argG) {
        g = argG;
    }


    public void DrawSPoint(ICurve curve) {
        IPoint SPoint;
        SPoint = curve.GetPoint(0);
        g.setFill(Color.BLACK);
        double rectsize = 5;
        g.fillRect(SPoint.GetX()-rectsize, SPoint.GetY()-rectsize, 2*rectsize, 2*rectsize);
    }

    public void DrawFPoint(ICurve curve) {
        IPoint FPoint;
        FPoint = curve.GetPoint(1);
        g.setFill(Color.BLACK);
        double rectsize = 5;
        g.fillRect(FPoint.GetX()-rectsize, FPoint.GetY()-rectsize, 2*rectsize, 2*rectsize);

    }

    public void DrawCurveBody(ICurve curve) {
        IPoint SPoint, TPoint1,TPoint2;
        SPoint = curve.GetPoint(0);
        g.setStroke(Color.BLACK);
        double step = 0.1;
        TPoint2 = SPoint;
        for (double i = step; i <= 1; i+=step*2) {
            TPoint1 = curve.GetPoint(i-step);
            TPoint2 = curve.GetPoint(i);
            g.strokeLine(TPoint1.GetX(), TPoint1.GetY(), TPoint2.GetX(), TPoint2.GetY());
        }

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

}
