# Name: RasterToPolyline_Ex_02.py
# Description: Converts a raster dataset to polyline features.
# Requirements: None

# Import system modules
import arcpy
from arcpy import env

# Set environment settings
env.workspace = "C:/data"

# Set local variables
inRaster = "flowstr"
outLines = "c:/output/flowstream.shp"
backgrVal = "ZERO"
dangleTolerance = 50
field = "VALUE"

# Execute RasterToPolygon
arcpy.RasterToPolyline_conversion(inRaster, outLines, backgrVal, 
                                  dangleTolerance, "SIMPLIFY", field)
