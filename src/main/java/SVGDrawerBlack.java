import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SVGDrawerBlack implements IDrawer{

    PrintWriter writer;

    public void DrawSPoint(ICurve curve) {
        IPoint SPoint;
        SPoint = curve.GetPoint(0);
        writer.print("\n\t<rect  x=\""+Double.toString(SPoint.GetX()-5)+"\" y = \""+
                Double.toString(SPoint.GetY()-5)+"\" width=\"10\" height=\"10\" stroke=\"black\" stroke-width=\"2\" fill=\"black\"/>");
    }

    public void DrawFPoint(ICurve curve) {
        IPoint FPoint;
        FPoint = curve.GetPoint(1);
        writer.print("\n\t<rect  x=\""+Double.toString(FPoint.GetX()-5)+"\" y = \""+
                Double.toString(FPoint.GetY()-5)+"\" width=\"10\" height=\"10\" stroke=\"black\" stroke-width=\"2\" fill=\"black\"/>");
    }

    public void DrawCurveBody(ICurve curve) {
        IPoint SPoint, TPoint1,TPoint2;
        SPoint = curve.GetPoint(0);
        double step = 0.05;
        TPoint2 = SPoint;
        for (double i = step; i <= 1; i+=step*2) {
            TPoint1 = curve.GetPoint(i-step);
            TPoint2 = curve.GetPoint(i);
            writer.print("\n\t<line x1=\""+Double.toString(TPoint1.GetX())+"\" x2=\""+Double.toString(TPoint2.GetX())+
                    "\" y1=\""+Double.toString(TPoint1.GetY())+"\" y2=\""+Double.toString(TPoint2.GetY())+
                    "\" stroke=\"black\" stroke-width=\"2\"/>");
//            g.strokeLine(TPoint1.GetX(), TPoint1.GetY(), TPoint2.GetX(), TPoint2.GetY());
        }

    }



    public void Draw(ICurve curve) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        writer = null;
        try {
            writer = new PrintWriter(currentDate+"_black"+".svg", "UTF-8");
            writer.print("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"400\" height=\"400\" version=\"1.1\">");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        DrawCurveBody(curve);
        DrawSPoint(curve);
        DrawFPoint(curve);
        writer.print("\n</svg>");
        writer.close();
    }

    public void DrawOnlyBody(ICurve curve) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        writer = null;
        try {
            writer = new PrintWriter(currentDate+"_black"+".svg", "UTF-8");
            writer.print("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"400\" height=\"400\" version=\"1.1\">");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        DrawCurveBody(curve);
        writer.print("\n</svg>");
        writer.close();
    }

    public void DrawWithoutSPoint(ICurve curve) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        writer = null;
        try {
            writer = new PrintWriter(currentDate+"_black"+".svg", "UTF-8");
            writer.print("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"400\" height=\"400\" version=\"1.1\">");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        DrawCurveBody(curve);
        DrawFPoint(curve);
        writer.print("\n</svg>");
        writer.close();
    }

    public void DrawWithoutFPoint(ICurve curve) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        writer = null;
        try {
            writer = new PrintWriter(currentDate+"_black"+".svg", "UTF-8");
            writer.print("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"400\" height=\"400\" version=\"1.1\">");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        DrawCurveBody(curve);
        DrawSPoint(curve);
        writer.print("\n</svg>");
        writer.close();
    }

}
