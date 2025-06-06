package im.zhaojun.zfile.module.storage.model.request.operator;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author mark.yu
 * @date 2025/6/6 11:30
 */
@Data
@Schema(description = "压缩文件夹请求")
public class CompressionRequest {


    @Schema(name = "存储源 key", requiredMode = Schema.RequiredMode.REQUIRED, example = "local")
    @NotBlank(message = "存储源 key 不能为空")
    private String storageKey;

    /**
     * 父路径
     */
    @Schema(name = "父路径", requiredMode = Schema.RequiredMode.REQUIRED, example = "local")
    private String path;
    /**
     * 待压缩的目录
     */
    @Schema(name = "待压缩的目录", requiredMode = Schema.RequiredMode.REQUIRED, example = "local")
    @NotBlank(message = "待压缩的目录不能为空")
    private String name;


    /**
     * 输出路径
     */
    @Schema(name = "输出路径", requiredMode = Schema.RequiredMode.REQUIRED, example = "local")
    private String targetPath;
    /**
     * 待压缩的目录
     */
    @Schema(name = "输出文件名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "local")
    private String targetName;


    @Schema(name = "源文件夹密码, 如果文件夹需要密码才能访问，则支持请求密码", example = "123456")
    private String srcPathPassword;

    @Schema(name = "目标文件夹密码, 如果文件夹需要密码才能访问，则支持请求密码", example = "123456")
    private String targetPathPassword;

}
