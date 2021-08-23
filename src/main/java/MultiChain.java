import java.util.ArrayList;

public class MultiChain extends ACurve{

    protected ArrayList<ICurve> curveList;

    public MultiChain(ArrayList<ICurve> argCurveList) {
        curveList = argCurveList;
    }

    @Override
    public IPoint GetPoint(double t) {
        int curveNum = curveList.size();
        int biggerT = (int)(t*curveNum);
        if (biggerT == t*curveNum && t!=0)
            biggerT-=1;
        System.out.println("t: " +t);
        System.out.println(t*curveNum);
        System.out.println(biggerT);
        if (biggerT==0) {
            return curveList.get(biggerT).GetPoint(t*curveNum);
        } else {
            IPoint p1 = curveList.get(0).GetPoint(0);
            int i = 0;
            while (i < biggerT) {
                p1.SetX(p1.GetX() - curveList.get(i).GetPoint(0).GetX() + curveList.get(i).GetPoint(1).GetX());
                p1.SetY(p1.GetY() - curveList.get(i).GetPoint(0).GetY() + curveList.get(i).GetPoint(1).GetY());
                i++;
            }
            IPoint p2 = curveList.get(biggerT).GetPoint(t*curveNum - biggerT);
            System.out.println(t*curveNum - biggerT);
            IPoint p3 = curveList.get(biggerT).GetPoint(0);
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
