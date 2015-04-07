uniform sampler2D tex0;
uniform vec4 rot;
uniform float boost;

void main (void) 
{ 
    vec2 newcoord;

	vec2 texcoord = (gl_TextureMatrix[0] * gl_TexCoord[0]).st -vec2(0.5,0.5);
	vec4 sample = texture2D(tex0, texcoord+vec2(0.5, 0.5));
    newcoord.x = texcoord.x*rot.r + texcoord.y*rot.g;
    newcoord.y = texcoord.x*rot.b + texcoord.y*rot.a;

    sample += texture2D(tex0, newcoord+vec2(0.5, 0.5));
 
    sample *= 0.5 * (boost+1.);

	gl_FragColor =  sample;
} 


