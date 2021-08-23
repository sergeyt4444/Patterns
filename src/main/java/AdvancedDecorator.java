import java.util.ArrayList;

public class AdvancedDecorator implements ICurve{

    protected IDrawer drawer1;
    protected IDrawer drawer2;

    protected MultiChain multiChain;

    public AdvancedDecorator(ArrayList<ICurve> argCurveList) {
        multiChain = new MultiChain(argCurveList);
    }

    public AdvancedDecorator(MultiChain argMultiChain) {
        multiChain = argMultiChain;
    }

    public void SetDrawers(IDrawer argDrawer1, IDrawer argDrawer2) {
        drawer1 = argDrawer1;
        drawer2 = argDrawer2;
    }

    public void Draw() {
        int i = 0;
        IPoint curPoint = multiChain.curveList.get(0).GetPoint(0);
        for (ICurve curve: multiChain.curveList) {
            MoveTo curveMoved = new MoveTo(curve, curPoint);
            if (i%2 == 0) {
                curveMoved.SetDrawer(drawer1);
            }
            else {
                curveMoved.SetDrawer(drawer2);
            }
            if (i == 0) {
                curveMoved.DoDrawWithoutFPoint();
            }
            else if (i == multiChain.curveList.size() - 1) {
                curveMoved.DoDrawWithoutSPoint();
            }
            else {
                curveMoved.DoDrawOnlyBody();
            }
            curPoint = curveMoved.GetPoint(1);
            i++;
        }
    }

    @Override
    public IPoint GetPoint(double t) {
        return multiChain.GetPoint(t);
    }



}
