public class Reverse extends CurveDecorator{

    public Reverse(ICurve curve) {
        super(curve);
    }

    @Override
    public IPoint GetPoint(double t) {
        return curve.GetPoint(1-t);
    }

}
