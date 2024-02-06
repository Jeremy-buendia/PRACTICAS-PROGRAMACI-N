package unidad3;

public class pruebaCuerpo {
	public static void main(String[] args) {
		// Creamos un nuevo objeto Organo
		Organo organo = new Organo();
		// System.out.println(organo);

		Organo corazon = new Organo("Corazon", "servir", 1, 400, Organo.TRONCO_SUPERIOR, Organo.VITAL, "hola", true);
		// System.out.println(corazon);

		Cuerpo juan = new Cuerpo();
		System.out.println(juan);

		// Creamos organos con caracteristicas concretas y los metemos en un array.
		Organo[] listaOrganos = new Organo[8];
		Organo organo1 = new Organo("Cerebro", "servir", Organo.DOLOR, 300.0, Organo.CABEZA, Organo.VITAL, "Imagen",
				false);
		listaOrganos[0] = organo1;
		Organo organo2 = new Organo("Corazon", "servir", Organo.SANO, 300.0, Organo.TRONCO_SUPERIOR, Organo.VITAL,
				"Imagen", false);
		listaOrganos[1] = organo2;
		Organo organo3 = new Organo("Pulmon derecho", "servir", Organo.DOLOR, 300.0, Organo.TRONCO_SUPERIOR,
				Organo.VITAL, "Imagen", false);
		listaOrganos[2] = organo3;
		Organo organo4 = new Organo("Pulmon izquierdo", "servir", Organo.PERJUDICADO, 300.0, Organo.TRONCO_SUPERIOR,
				Organo.VITAL, "Imagen", false);
		listaOrganos[3] = organo4;
		Organo organo5 = new Organo("Riñon derecho", "servir", Organo.PERJUDICADO, 300.0, Organo.TRONCO_INFERIOR,
				Organo.BASICA, "Imagen", false);
		listaOrganos[4] = organo5;
		Organo organo6 = new Organo("Riñon izquierdo", "servir", Organo.SANO, 300.0, Organo.TRONCO_INFERIOR,
				Organo.BASICA, "Imagen", false);
		listaOrganos[5] = organo6;
		Organo organo7 = new Organo("Estomago", "servir", Organo.DOLOR, 300.0, Organo.TRONCO_INFERIOR,
				Organo.SECUNDARIA, "Imagen", false);
		listaOrganos[6] = organo7;
		Organo organo8 = new Organo("Oido", "servir", Organo.CANCERIGENO, 300.0, Organo.CABEZA, Organo.SECUNDARIA,
				"Imagen", false);
		listaOrganos[7] = organo8;
		// Ponemos el array listaOrganos como los organos del cuerpo llamado Juan
		juan.setOrganos(listaOrganos);

		// Pruebas de funcion revision
		System.out.println(organo.revision());

		// Pruebas de funcion analisis
		System.out.println(organo.analisis(1));
		System.out.println(organo.analisis(2));
		System.out.println(organo.analisis(3));

		// Pruebas de funcion transplante
		System.out.println("Función transplante:" + juan.transplante(corazon));
		System.out.println(juan);

		// Prueba de funcion cura
		System.out.println("Función cura:" + juan.cura(listaOrganos[2]));

		// Prueba de funcion oncológica
		System.out.println("Prueba oncológica: " + juan.oncologia());

		// Prueba de funcion revisionGeneral
		int[] codigos = juan.revisionGeneral();
		for (int codigo : codigos) {
			if (codigo != 0)
				System.out.println("Enfermedad con código " + codigo);
		}
	}
}
