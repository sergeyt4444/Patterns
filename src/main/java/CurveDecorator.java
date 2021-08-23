public class CurveDecorator extends ACurve{

    protected ICurve curve;

    public CurveDecorator(ICurve argCurve) {
        curve = argCurve;
    }

    @Override
    public IPoint GetPoint(double t) {
        return curve.GetPoint(t);
    }

    public void Draw() {
        DoDraw();
    }

    public void DrawOnlyBody() {
        DoDrawWithoutFPoint();
    }

    public void DrawWithoutSPoint() {
        DoDrawWithoutSPoint();
    }

    public void DrawWithoutFPoint() {
        DoDrawOnlyBody();
    }


}
