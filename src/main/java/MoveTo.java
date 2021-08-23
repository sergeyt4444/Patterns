public class MoveTo extends CurveDecorator{

    protected IPoint p;

    public MoveTo(ICurve argCurve, IPoint argP) {
        super(argCurve);
        p = argP;
    }

    public void SetPoint(IPoint argP) {
        p = argP;
    }

    @Override
    public IPoint GetPoint(double t) {
        IPoint result = new Point();
        result.SetX(curve.GetPoint(t).GetX() - curve.GetPoint(0).GetX() + p.GetX());
        result.SetY(curve.GetPoint(t).GetY() - curve.GetPoint(0).GetY() + p.GetY());
        return result;
    }

}
