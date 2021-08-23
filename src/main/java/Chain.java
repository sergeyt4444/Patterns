public class Chain extends ACurve {

    protected ICurve leftCurve, rightCurve;

    public Chain(ICurve argCurve1, ICurve argCurve2) {
        leftCurve = argCurve1;
        rightCurve = argCurve2;

    }


    @Override
    public IPoint GetPoint(double t) {
        if (t <= 0.5) {
            return leftCurve.GetPoint(2 * t);
        } else {
            IPoint p1 = leftCurve.GetPoint(1);
            IPoint p2 = rightCurve.GetPoint(2 * (t - 0.5));
            IPoint p3 = rightCurve.GetPoint(0);
            IPoint result = new Point();
            result.SetX(p1.GetX() + p2.GetX() - p3.GetX());
            result.SetY(p1.GetY() + p2.GetY() - p3.GetY());
            return result;
        }
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