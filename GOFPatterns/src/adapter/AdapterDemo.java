package adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        VectorGraphicsInterface vector = new VectorAdapterFromRaster();

        vector.drawLine();
        vector.drawSquare();
    }
}

interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}

class RasterGraphics {
    public void drawRasterLine() {
        System.out.println("Draw raster line");
    }

    public void drawRasterSquare() {
        System.out.println("Draw raster square");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}
