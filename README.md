**Core & Rendering**

**Stage.java:**

The entry point of the application. It initializes the JFrame, sets the system look-and-feel, and hosts the main Scene.

**Scene.java:** 

Acts as the primary layout container. It organizes the Canvas and the toolbars (ToolsFarbe and ToolsBreite) within a single panel.

**Canvas.java:** 

The central drawing component.
Uses a BufferedImage as an off-screen buffer to persist drawings.
Implements MouseListener and MouseMotionListener to handle user input.
Contains the recursive flood-fill logic (fillAreaRecursive) to color connected pixels.

**R.java:** 

A resource class holding global static variables, such as the current stiftFarbe (color), stiftBreite (width), and whether the fillActive mode is enabled.
UI Components (Tools & Buttons)
The tools are organized into specialized panels for better usability:

**ToolsFarbe.java & ButtonFarbe.java:**

Provides a color palette. ButtonFarbe is a custom JButton that renders a colored circle to represent the selectable color.

**ToolsBreite.java & ButtonBreite.java:**

Allows users to select line thicknesses. ButtonBreite visualizes the stroke width by drawing a line of corresponding thickness on the button face.

**ButtonFill.java:**

A specialized button that activates the flood-fill mode. It loads an external icon (pics/fill.png) to represent the bucket tool.

**Key Features:**

-Freehand Drawing: Smooth line rendering using Graphics2D and mouse motion events.

-Flood-Fill Tool: An implementation of the flood-fill algorithm to fill enclosed shapes with the selected color.

-Visual Feedback: Custom-painted buttons provide immediate visual cues for selected colors and line weights.

-Antialiasing: Uses RenderingHints to ensure smooth, high-quality edges for all drawn elements.
