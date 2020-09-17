package com.kitfox.svg;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * @author VISTALL
 * @since 2020-09-17
 */
public class Mask extends ShapeElement {
  public static final String TAG_NAME = "MASK";

  @Override
  protected void build() throws SVGException {
    super.build();
  }

  @Override
  public void render(Graphics2D g) throws SVGException {
//    for (SVGElement child : children) {
//      if(child instanceof RenderableElement) {
//        ((RenderableElement)child).render(g);
//      }
//    }
  }

  @Override
  public Shape getShape() {
    for (SVGElement child : children) {
      if(child instanceof ShapeElement) {
        return ((ShapeElement)child).getShape();
      }
    }
    return null;
  }

  @Override
  public Rectangle2D getBoundingBox() throws SVGException {
    return null;
  }

  @Override
  public String getTagName() {
    return TAG_NAME;
  }
}
