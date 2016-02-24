<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <head>
  <style>
  div.item {
  float: left;
  border-style:solid;
  border-radius: 15px;
  border-width: 1px;
  margin: 1px;
  width:320px;
  }
  div.key {
  text-align:center;
  float: right;
  padding-right:25px;
  }
  div.line{  border-style:solid;
  border-width: 0.1px;}
  div.case {padding-left: 5px;}
  span {padding-left:10px;}
  </style>
  </head>
  <body>
  <!-- <h3><xsl:value-of select="rss/channel/link"/></h3> -->
    <xsl:for-each select="rss/channel/item">
 	<div class="item">
    <div class="case" style="padding-top: 5px;">
		<xsl:if test="type">
			<img src="{type/@iconUrl}"/> -  <xsl:value-of select="type"/> -  
        </xsl:if>
        <xsl:if test="priority">
        	<img src="{priority/@iconUrl}"/> -  <xsl:value-of select="priority"/>
        </xsl:if> 
        <div class="key"> <strong><xsl:value-of select="key"/></strong> </div>
    </div>
    <div class="line" />
    <div class="case">
    	<div title="Summary">
    	<xsl:if test="string-length(summary) > 42">
      			<xsl:value-of select="concat(substring(summary,0,42),'...')"/>
      		</xsl:if>
      		<xsl:if test="42 >= string-length(summary)">
      			<xsl:value-of select="summary"/>
      		</xsl:if>
  		</div>
    </div>
    <div class="case" tile="fixversion">
        <div>
        	<em>Version:</em>  <span><xsl:value-of select="fixVersion"/></span>
        </div>
    </div>
	<div class="case" title="Affects Version">
		<div>
			<em>Affects Version:</em> <span><xsl:value-of select="version"/></span>
		</div>
    </div>
    <div class="case" title="Edit Assignee">
        <div>
    		<em>Assignee:</em> <span><xsl:value-of select="assignee"/></span>
  		</div>
  	</div>
    <div class="case" title="Original Estimate">
        <div>
        	<em>Original Estimate:</em> <span><xsl:value-of select="timeoriginalestimate"/> </span>
        </div>
	</div>
    <div class="case" title="Remaining">
    	<div>
        	<em>Remaining:</em> <span><xsl:value-of select="timeestimate"/></span>
    	</div>
    </div>
    <div class="case" title="Time Spent">
		<div>
        	<em>Time Spent:</em> <span><xsl:value-of select="timespent"/></span>	
        </div>
    </div>
<!--    <div class="case" title="Support Status">												-->
<!--    	<div>																				-->
<!--        	<em>Support Status:</em>														-->
<!--        	<xsl:for-each select="customfields/customfield">								-->
<!--        		<xsl:if test="customfieldname = 'Support Status'">							-->
<!--					<span><xsl:value-of select="customfieldvalues/customfieldvalue"/></span>-->
<!--        		</xsl:if>																	-->
<!--			</xsl:for-each>																	-->
<!--        </div>																				-->
<!--    </div> 																					-->
<!--	<div class="case" title="Status" style="padding-bottom: 5px;">								-->
<!--    	<div>																					-->
<!--        	<em>Status:</em> <span><xsl:value-of select="status"/></span>						-->
<!--        </div>																					-->
<!--	</div>																						-->
   </div>
    </xsl:for-each>       		

  </body>
  </html>
</xsl:template>

</xsl:stylesheet> 