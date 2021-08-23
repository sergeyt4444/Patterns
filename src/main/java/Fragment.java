public class Fragment extends CurveDecorator{

    protected double start, finish;

    public Fragment(ICurve argCurve, double startArg, double finishArg) {
        super(argCurve);
        start = startArg;
        finish = finishArg;
    }

    public void SetLimits(double startArg, double finishArg) {
        start = startArg;
        finish = finishArg;
    }

    @Override
    public IPoint GetPoint(double t) {
        double decoratedT = start + (finish - start)*t;
        return curve.GetPoint(decoratedT);
    }

}
