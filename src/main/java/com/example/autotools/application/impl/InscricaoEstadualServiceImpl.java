// CÓDIGO COMPLETO E ATUALIZADO
package com.example.autotools.application.impl;

import com.example.autotools.application.InscricaoEstadualService;
import com.example.autotools.domain.Uf;
import com.example.autotools.web.dto.GeneratedIeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.EnumMap;
import java.util.Map;

@Service
public class InscricaoEstadualServiceImpl implements InscricaoEstadualService {

    private static final Logger logger = LoggerFactory.getLogger(InscricaoEstadualServiceImpl.class);
    private final SecureRandom random = new SecureRandom();

    // Mapa com os formatos de IE para cada estado. '#' será substituído por um dígito aleatório.
    private static final Map<Uf, String> IE_FORMATS = new EnumMap<>(Uf.class);

    static {
        IE_FORMATS.put(Uf.AC, "01.###.###/###-##");
        IE_FORMATS.put(Uf.AL, "#########");
        IE_FORMATS.put(Uf.AP, "#########");
        IE_FORMATS.put(Uf.AM, "##.###.###-#");
        IE_FORMATS.put(Uf.BA, "#######-##");
        IE_FORMATS.put(Uf.CE, "########-#");
        IE_FORMATS.put(Uf.DF, "###########-##");
        IE_FORMATS.put(Uf.ES, "###.###.##-#");
        IE_FORMATS.put(Uf.GO, "##.###.###-#");
        IE_FORMATS.put(Uf.MT, "###########");
        IE_FORMATS.put(Uf.MS, "#########");
        IE_FORMATS.put(Uf.MG, "###.###.###/####");
        IE_FORMATS.put(Uf.PA, "##-######-#");
        IE_FORMATS.put(Uf.PB, "########-#");
        IE_FORMATS.put(Uf.PR, "###.#####-##");
        IE_FORMATS.put(Uf.PE, "##.###.###-##");
        IE_FORMATS.put(Uf.PI, "#########");
        IE_FORMATS.put(Uf.RJ, "##.###.##-#");
        IE_FORMATS.put(Uf.RN, "##.###.###-#");
        IE_FORMATS.put(Uf.RS, "###/#######");
        IE_FORMATS.put(Uf.RO, "#############-#");
        IE_FORMATS.put(Uf.RR, "########-#");
        IE_FORMATS.put(Uf.SC, "###.###.###");
        IE_FORMATS.put(Uf.SE, "#########-#");
        IE_FORMATS.put(Uf.TO, "###########");
    }

    @Override
    public GeneratedIeDto generateRandomIe(Uf uf) {
        String ie = switch (uf) {
            // Casos com implementação real (mantidos)
            case SP -> generateSpIe();
            case MA -> generateMaIe();
            // Para todos os outros estados, usamos o novo mock inteligente
            default -> generateMockIe(uf);
        };
        logger.info("Generated IE for {}: {}", uf, ie);
        return new GeneratedIeDto(uf.name(), ie);
    }

    // MÉTODO MOCK ATUALIZADO
    private String generateMockIe(Uf uf) {
        logger.warn("Generating MOCK IE for {}. Using random digits based on format.", uf);
        String format = IE_FORMATS.getOrDefault(uf, "######### (MOCK)");

        StringBuilder ieBuilder = new StringBuilder();
        for (char c : format.toCharArray()) {
            if (c == '#') {
                ieBuilder.append(random.nextInt(10));
            } else {
                ieBuilder.append(c);
            }
        }
        return ieBuilder.toString() + " (MOCK)";
    }

    // Implementação real para MARANHÃO (MA)
    private String generateMaIe() {
        // (código mantido como estava)
        int[] base = random.ints(6, 0, 10).toArray();
        String baseStr = "12" +
                String.valueOf(base[0]) + String.valueOf(base[1]) + String.valueOf(base[2]) +
                String.valueOf(base[3]) + String.valueOf(base[4]) + String.valueOf(base[5]);

        int[] weights = {9, 8, 7, 6, 5, 4, 3, 2};
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            sum += Character.getNumericValue(baseStr.charAt(i)) * weights[i];
        }

        int remainder = sum % 11;
        int dv = (remainder == 0 || remainder == 1) ? 0 : 11 - remainder;

        return baseStr + dv;
    }

    // Implementação real para SÃO PAULO (SP)
    private String generateSpIe() {
        // (código mantido como estava)
        int[] base = random.ints(8, 0, 10).toArray();
        String baseStr = "P" + String.format("%08d",
                (base[0] * 10000000L) + (base[1] * 1000000L) + (base[2] * 100000L) +
                        (base[3] * 10000L) + (base[4] * 1000L) + (base[5] * 100L) +
                        (base[6] * 10L) + base[7]);

        int[] weights = {1, 3, 4, 5, 6, 7, 8, 10};
        int sum = 0;
        for (int i = 1; i < 9; i++) {
            sum += Character.getNumericValue(baseStr.charAt(i)) * weights[i - 1];
        }

        int dv = sum % 11;
        if (dv >= 10) {
            dv = dv % 10;
        }

        String unformatted = baseStr + dv;
        return String.format("%s-%s.%s/%s",
                unformatted.substring(0, 9),
                unformatted.substring(9, 10),
                "0",
                "001");
    }
}