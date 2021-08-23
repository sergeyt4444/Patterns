public class Bezier extends ACurve{

    protected IPoint a,b, c,d;

    public Bezier(IPoint argA, IPoint argB, IPoint argC, IPoint argD) {
        a = argA;
        b = argB;
        c = argC;
        d = argD;
    }

    @Override
    public IPoint GetPoint(double t) {
        Point result = new Point();
        result.SetX(a.GetX()*(1-t)*(1-t)*(1-t) + t*t*t*b.GetX() + 3*(1-t)*(1-t)*t*c.GetX() + 3*(1-t)*t*t*d.GetX());
        result.SetY(a.GetY()*(1-t)*(1-t)*(1-t) + t*t*t*b.GetY() + 3*(1-t)*(1-t)*t*c.GetY() + 3*(1-t)*t*t*d.GetY());
        return result;
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
