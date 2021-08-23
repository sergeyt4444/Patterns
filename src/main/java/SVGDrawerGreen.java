import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SVGDrawerGreen implements IDrawer{

    PrintWriter writer;

    public void DrawSPoint(ICurve curve) {
        IPoint SPoint;
        SPoint = curve.GetPoint(0);
        writer.print("\n\t<ellipse cx=\""+Double.toString(SPoint.GetX())+"\" cy=\""+Double.toString(SPoint.GetY())+
                "\" rx=\"5\" ry=\"5\" stroke-width=\"2\" fill=\"green\"/>");

    }

    public void DrawFPoint(ICurve curve) {
        IPoint FPoint, PFPoint;
        FPoint = curve.GetPoint(1);
        PFPoint = curve.GetPoint(0.95);
        double ArrowLength1, ArrowLength2;
        ArrowLength1 = ArrowLength2 = 8;
        double dx = FPoint.GetX() - PFPoint.GetX();
        double dy = FPoint.GetY() - PFPoint.GetY();
        double LineLenght =  Math.sqrt(dx * dx + dy * dy);
        IPoint TempPoint, ArrowPoint1,ArrowPoint2;
        TempPoint = new Point();
        TempPoint.SetX(FPoint.GetX() - dx * (ArrowLength1/LineLenght));
        TempPoint.SetY(FPoint.GetY() - dy*(ArrowLength1/LineLenght));
        ArrowPoint1 = new Point();
        ArrowPoint1.SetX(TempPoint.GetX() + dy * (ArrowLength2/LineLenght));
        ArrowPoint1.SetY(TempPoint.GetY() - dx*(ArrowLength2/LineLenght));
        ArrowPoint2 = new Point();
        ArrowPoint2.SetX(TempPoint.GetX() - dy * (ArrowLength2/LineLenght));
        ArrowPoint2.SetY(TempPoint.GetY() + dx*(ArrowLength2/LineLenght));
        writer.print("\n\t<line x1=\""+Double.toString(ArrowPoint1.GetX())+"\" x2=\""+Double.toString(FPoint.GetX())+
                "\" y1=\""+Double.toString(ArrowPoint1.GetY())+"\" y2=\""+Double.toString(FPoint.GetY())+
                "\" stroke=\"green\" stroke-width=\"2\"/>");
        writer.print("\n\t<line x1=\""+Double.toString(ArrowPoint2.GetX())+"\" x2=\""+Double.toString(FPoint.GetX())+
                "\" y1=\""+Double.toString(ArrowPoint2.GetY())+"\" y2=\""+Double.toString(FPoint.GetY())+
                "\" stroke=\"green\" stroke-width=\"2\"/>");

        //g.strokeLine(ArrowPoint1.GetX(), ArrowPoint1.GetY(), FPoint.GetX(), FPoint.GetY());
        //g.strokeLine(ArrowPoint2.GetX(), ArrowPoint2.GetY(), FPoint.GetX(), FPoint.GetY());

    }

    public void DrawCurveBody(ICurve curve) {
        IPoint SPoint, TPoint1,TPoint2;
        SPoint = curve.GetPoint(0);
        double step = 0.05;
        TPoint2 = SPoint;
        for (double i = step; i <= 1; i+=step) {
            TPoint1 = TPoint2;
            TPoint2 = curve.GetPoint(i);
            writer.print("\n\t<line x1=\""+Double.toString(TPoint1.GetX())+"\" x2=\""+Double.toString(TPoint2.GetX())+
                    "\" y1=\""+Double.toString(TPoint1.GetY())+"\" y2=\""+Double.toString(TPoint2.GetY())+
                    "\" stroke=\"green\" stroke-width=\"2\"/>");
        }
        TPoint1 = curve.GetPoint(1 - step);
        TPoint2 = curve.GetPoint(1);
        writer.print("\n\t<line x1=\""+Double.toString(TPoint1.GetX())+"\" x2=\""+Double.toString(TPoint2.GetX())+
                "\" y1=\""+Double.toString(TPoint1.GetY())+"\" y2=\""+Double.toString(TPoint2.GetY())+
                "\" stroke=\"green\" stroke-width=\"2\"/>");

    }



    public void Draw(ICurve curve) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        writer = null;
        try {
            writer = new PrintWriter(currentDate+"_green"+".svg", "UTF-8");
            writer.print("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"400\" height=\"400\" version=\"1.1\">\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        DrawCurveBody(curve);
        DrawSPoint(curve);
        DrawFPoint(curve);
        writer.print("</svg>");
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
