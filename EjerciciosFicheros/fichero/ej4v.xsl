<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
  <html>
  <head>
      <style>
			body{
				background-color: #cd546e;
			}
			fila1{
				background-color: #333333;
				color: #ffffff;
			}
			table *{
				border: solid 1px #de548f;
			}
      </style>
  </head>
  <body>
    <table>
      <tr class="fila1">
        <th>Usuarios</th>
      </tr>
      <xsl:for-each select="usuarios/usuario">
      <tr>
        <td><xsl:value-of select="nombre"/></td>
        <td><xsl:value-of select="password"/></td>
        <td><xsl:value-of select="conexion"/></td>
      </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>
