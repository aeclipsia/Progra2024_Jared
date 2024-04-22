<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
  <html>
  <head>
      <style>
	  body {
		font-family: Calibri;
		font-size:14px;
        text-align:center;
        width: 200px;
        background-color: #a795ed;
	}
	  .fila1 {
		background-color:#8264f5;
		text-align:center;
		height:40px;
        width: 100%;
      }
      table *{
        margin: 1px;
        border: solid #484163 1px;
    }
      </style>
  </head>
  <body>
    <p>Usuarios del ordenador</p>
    <table>
      <tr class="fila1">
        <th>Usuarios</th>
        <th>Contraseña</th>
        <th>Conexión</th>
      </tr>
      <xsl:for-each select="/usuarios/usuario">
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
