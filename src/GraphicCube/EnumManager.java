//Roberto, Thiago - Trabalho 04 - 2017.1
package GraphicCube;

/**
 * Classe responsável por gerenciar as enumerações do projeto
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class EnumManager {

    /**
     * Método conversor de enumeração de cor do cubo gráfico para o cubo lógico.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Enum de cor do cubo gráfico. 
     * @return LogicCube.Color - Enum de cor do cubo lógico correspondente ao parâmetro.
     */
    public static LogicCube.Color convertGraficLogicColorEnum(GraficColor color) {
        switch (color) {
            case WH:
                return LogicCube.Color.WH;
            case RE:
                return LogicCube.Color.RE;
            case GR:
                return LogicCube.Color.GR;
            case BL:
                return LogicCube.Color.BL;
            case OR:
                return LogicCube.Color.OR;
            case YE:
                return LogicCube.Color.YE;
        }
        return null;
    }

}
