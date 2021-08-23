public class Line extends ACurve{

    protected IPoint a,b;

    public Line(IPoint argA, IPoint argB) {
        a = argA;
        b = argB;
    }

    @Override
    public IPoint GetPoint(double t) {
        Point result = new Point();
        result.SetX(a.GetX()*(1-t) + t*b.GetX());
        result.SetY(a.GetY()*(1-t) + t* b.GetY());
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
