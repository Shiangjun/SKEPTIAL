# Name: RasterToPolygon_Ex_02.py
# Description: Converts a raster dataset to polygon features.
# Requirements: None

# Import system modules
import arcpy
from arcpy import env

# Set environment settings
env.workspace = "C:/data"

# Set local variables
inRaster = "zone"
outPolygons = "c:/output/zones.shp"
field = "VALUE"

# Execute RasterToPolygon
arcpy.RasterToPolygon_conversion(inRaster, outPolygons, "NO_SIMPLIFY", field)
