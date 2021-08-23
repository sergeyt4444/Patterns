public class ConsoleDrawer implements IDrawer{

    protected char[][] contents;

    public ConsoleDrawer() {
        contents = new char[40][200];
        for(int i = 0; i < 40; i++)
            for (int j = 0; j < 200; j++) {
                contents[i][j] = '_';
            }
    }

    protected void Clear() {
        for(int i = 0; i < 40; i++)
            for (int j = 0; j < 200; j++) {
                contents[i][j] = '_';
            }
    }

    public void DrawSPoint(ICurve curve) {
        IPoint SPoint = curve.GetPoint(0);
        contents[(int)(SPoint.GetY()/10)][(int)(SPoint.GetX()/2)]='A';
    }

    public void DrawFPoint(ICurve curve) {
        IPoint FPoint = curve.GetPoint(1);
        contents[(int)(FPoint.GetY()/10)][(int)(FPoint.GetX()/2)]='B';

    }

    public void DrawCurveBody(ICurve curve) {
        IPoint TPoint;
        double step = 0.01;
        for (double i = 0; i <= 1; i+=step) {
            TPoint = curve.GetPoint(i);
            contents[(int)(TPoint.GetY()/10)][(int)(TPoint.GetX()/2)]='*';
        }

    }

    public void Draw(ICurve curve) {
        Clear();
        DrawCurveBody(curve);
        DrawSPoint(curve);
        DrawFPoint(curve);
        for(int i = 0; i < 40; i++) {
            for (int j = 0; j < 200; j++) {
                System.out.print(contents[i][j]);
            }
            System.out.print("\n");
        }
    }

    public void DrawOnlyBody(ICurve curve) {
        Clear();
        DrawCurveBody(curve);
        for(int i = 0; i < 40; i++) {
            for (int j = 0; j < 200; j++) {
                System.out.print(contents[i][j]);
            }
            System.out.print("\n");
        }
    }

    public void DrawWithoutSPoint(ICurve curve) {
        Clear();
        DrawCurveBody(curve);
        DrawFPoint(curve);
        for(int i = 0; i < 40; i++) {
            for (int j = 0; j < 200; j++) {
                System.out.print(contents[i][j]);
            }
            System.out.print("\n");
        }
    }

    public void DrawWithoutFPoint(ICurve curve) {
        Clear();
        DrawCurveBody(curve);
        DrawSPoint(curve);
        for(int i = 0; i < 40; i++) {
            for (int j = 0; j < 200; j++) {
                System.out.print(contents[i][j]);
            }
            System.out.print("\n");
        }
    }

}
