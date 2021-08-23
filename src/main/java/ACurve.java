public abstract class ACurve implements ICurve, IDrawable{

    private IDrawer drawer;

    public void SetDrawer(IDrawer argDrawer) {
        drawer = argDrawer;
    }

    public abstract void Draw();

    protected void DoDraw() {
        drawer.Draw(this);
    }

    protected void DoDrawOnlyBody() {
        drawer.DrawOnlyBody(this);
    }

    protected void DoDrawWithoutSPoint() {
        drawer.DrawWithoutSPoint(this);
    }

    protected void DoDrawWithoutFPoint() {
        drawer.DrawWithoutFPoint(this);
    }

    public ACurve() {

    }

    public abstract IPoint GetPoint(double t);

}
