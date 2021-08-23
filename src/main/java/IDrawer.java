public interface IDrawer {

    public void DrawSPoint(ICurve curve);
    public void DrawFPoint(ICurve curve);
    public void DrawCurveBody(ICurve curve);

    public void Draw(ICurve curve);

    public void DrawOnlyBody(ICurve curve);
    public void DrawWithoutSPoint(ICurve curve);
    public void DrawWithoutFPoint(ICurve curve);

}
