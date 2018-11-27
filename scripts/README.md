# Scripts for Skeptial

### Note: I strongly recommend to use Raster series convert functions because we could utilize ImageSketch directly. 
But if other methods are more promosing, I am open to suggestions.

## Raster2Points.py

This script functioned to transfer Raster Image into Points in standalone mode.

Details are [here](http://pro.arcgis.com/en/pro-app/tool-reference/conversion/raster-to-point.htm).

## Raster2Polygon.py

This script functioned to transfer Raster Image into Polygon in standalone mode.

Details are [here](http://pro.arcgis.com/en/pro-app/tool-reference/conversion/raster-to-polygon.htm), particularly I recommend to read the corrections.

## Raster2Polyline.py

This script functioned to transfer Raster Image into Polyline in standalone mode.

Details are [here](http://pro.arcgis.com/en/pro-app/tool-reference/conversion/raster-to-polyline.htm), particularly I recommend to read the corrections.

## Table2Table.py

This script functioned to transfer Table (e.g. csv, xlsx and so on) to Table.

Details are [here](http://pro.arcgis.com/en/pro-app/tool-reference/conversion/table-to-table.htm).

## Csv2Shp.py

This script functioned to transfer Csv to Shapfile, I would recommend u to start with this because it's quite easier.

  - Usage: csv2shp.py [options] inputFile [optional output filename]

    Options:<br>
        -h, --help     show this help message and exit<br>
        --lat=LAT_COL  latitude column name<br>
        --lng=LNG_COL  longitude column name<br>
        -j, --geojson  default to geojson output<br>
    Converts an input tsv/csv to a shapefile/geojson.<br> 
    Requires an input file with the first row being headers.<br>
